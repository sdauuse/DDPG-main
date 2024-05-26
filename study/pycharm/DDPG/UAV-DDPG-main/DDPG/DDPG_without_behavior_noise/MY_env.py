import math
import random

import numpy as np


class MyEnv(object):
    ######## 能耗计算部分-计算能耗
    # 压缩率
    nu_m = [0.8, 0.9, 1]
    # 数据量
    D_m = [1400, 1500, 1600]
    # D_m = 1600
    # batch size
    h_m = 64
    # c1
    c1 = 1
    # c2 or c2+c3
    c2 = 1
    T_m0 = 1
    # 每次本地聚合所需计算量
    phi = 1
    # 分配核心数,在0-1之间取值，
    beta_m = [0.1, 0.2, 0.3]
    # RSU最大核心数
    beta_max = [12, 14, 16]
    alpha_m = 0.9
    # 一个核心数的算力2.6GHZ
    # f_mem_m = 2.6 * (10 ** 9)
    # f_core_m = 2.6 * (10 ** 9)

    # 归一化一个核心数的算力2.6GHZ
    f_mem_m = 2.6 * (10 ** 9)
    ### 改成三个RSU的！
    f_core_m = [beta_max[0] * 2.6 * (10 ** 9), beta_max[1] * 2.6 * (10 ** 9), beta_max[2] * 2.6 * (10 ** 9)]

    # 计算时间公式
    T_com_div = [phi / (beta_m[0] * f_core_m[0]) + c1 / (alpha_m * f_mem_m) + c2 / (beta_m[0] * f_core_m[0]) + T_m0,
                 phi / (beta_m[1] * f_core_m[1]) + c1 / (alpha_m * f_mem_m) + c2 / (beta_m[1] * f_core_m[1]) + T_m0,
                 phi / (beta_m[2] * f_core_m[2]) + c1 / (alpha_m * f_mem_m) + c2 / (beta_m[2] * f_core_m[2]) + T_m0]

    T_com_m = [math.ceil(nu_m[0] * D_m[0] / h_m) * T_com_div[0],
               math.ceil(nu_m[1] * D_m[1] / h_m) * T_com_div[1],
               math.ceil(nu_m[2] * D_m[2] / h_m) * T_com_div[2]]
    # 背景任务算力分配,beta_m * beta_max这里的beta_m用了归一化
    # *3是因为考虑到三个RSU
    # f_bg_m = [(beta_max - beta_m * beta_max) * f_core_m] * 3
    f_bg_m = [(beta_max[0] - beta_m[0] * beta_max[0]) * f_core_m[0],
              (beta_max[1] - beta_m[1] * beta_max[1]) * f_core_m[1],
              (beta_max[2] - beta_m[2] * beta_max[2]) * f_core_m[2]]
    # 有效电容载荷
    C_m = 1
    # 计算能耗公式
    E_com_m = C_m * (beta_max[0] * f_core_m[0]) ** 2 * T_com_m[0] - C_m * f_bg_m[0] * T_com_m[0] + C_m * (
            beta_max[1] * f_core_m[1]) ** 2 * T_com_m[1] - C_m * f_bg_m[1] * T_com_m[1] + C_m * (
                      beta_max[2] * f_core_m[2]) ** 2 * T_com_m[2] - C_m * f_bg_m[2] * T_com_m[2]

    ##### 带宽分配部分
    bandwidth_nums = 1
    B = bandwidth_nums * 10 ** 6  # 带宽1MHz
    # 距离 500m
    D = 250
    # 噪声
    N = 10 ** (-20)
    # p= 20dbm = 0.1w
    p = 0.1
    # h
    h = 0.1
    h2 = h ** 2

    D = D ** (-4)
    gamma_m = [0.3, 0.3, 0.4]
    # 香农公式
    r1 = gamma_m[0] * B * math.log2(1 + (p * D * h2) / N)
    r2 = gamma_m[1] * B * math.log2(1 + (p * D * h2) / N)
    r3 = gamma_m[2] * B * math.log2(1 + (p * D * h2) / N)
    # 转换单位为MBps
    r1 = r1 / 1000 / 1000 / 8
    r2 = r2 / 1000 / 1000 / 8
    r3 = r3 / 1000 / 1000 / 8

    ######## 能耗计算部分-上传通信能耗
    # 本地训练后上传的聚合参数
    w = 1
    # 上传时间
    T_up_m = [w / r1, w / r2, w / r3]
    # 发送功率
    p_m = 1
    # 上传能耗
    E_up_m = p_m * (T_up_m[0] + T_up_m[1] + T_up_m[2])

    # RSU的数量
    M = 3
    T_t = T_com_m[0] + T_up_m[0] + T_com_m[1] + T_up_m[1] + T_com_m[2] + T_up_m[2]
    E_total = E_com_m + E_up_m
    reward = 0

    # 对应tahn激活函数
    action_bound = [-1, 1]
    # 表示三个RSU的action
    action_dim = 6
    # nu_m*3, D_m*3, p_m, D, f_bg_m*3, r1,r2,r3, beta_max*3
    state_dim = 5 + M * 4  # uav battery remain, uav loc, remaining sum task size, all ue loc, all ue task size, all ue block_flag
    # 一次玩耍，运行多少个round
    round_num = 500

    def __init__(self):
        # nu_m*3, D_m*3, p_m, D, f_bg_m*3, r1,r2,r3, beta_max*3
        self.start_state = np.append(self.nu_m, self.D_m)
        self.start_state = np.append(self.start_state, self.p_m)
        self.start_state = np.append(self.start_state, self.D)
        self.start_state = np.append(self.start_state, self.f_bg_m)
        self.start_state = np.append(self.start_state, self.r1)
        self.start_state = np.append(self.start_state, self.r2)
        self.start_state = np.append(self.start_state, self.r3)
        self.start_state = np.append(self.start_state, self.beta_max)
        self.state = self.start_state

    # reset_env赋予重置初始值，
    def reset_env(self):
        self.p_m = 1
        self.D = 250
        self.r1 = self.gamma_m[0] * self.B * math.log2(1 + (self.p * self.D * self.h2) / self.N)
        self.r2 = self.gamma_m[1] * self.B * math.log2(1 + (self.p * self.D * self.h2) / self.N)
        self.r3 = self.gamma_m[2] * self.B * math.log2(1 + (self.p * self.D * self.h2) / self.N)
        self.beta_max[0] = 12
        self.beta_max[1] = 14
        self.beta_max[2] = 16
        self.reset_step()

    # reset_step 重置压缩率和数据量
    def reset_step(self):
        self.D_m = np.random.randint(1400, 1600, self.M)
        self.nu_m = np.random.randint(0.7, 1, self.M)
        self.nu_m = np.random.uniform(0.7, 1, 3)
        self.nu_m = np.round(self.nu_m, 2)

    def reset(self):
        self.reset_env()
        # nu_m*3, D_m*3, p_m, D, f_bg_m*3, B, beta_max*3
        self.start_state = np.append(self.nu_m, self.D_m)
        self.start_state = np.append(self.start_state, self.p_m)
        self.start_state = np.append(self.start_state, self.D)
        self.start_state = np.append(self.start_state, self.f_bg_m)
        self.start_state = np.append(self.start_state, self.r1)
        self.start_state = np.append(self.start_state, self.r2)
        self.start_state = np.append(self.start_state, self.r3)
        self.start_state = np.append(self.start_state, self.beta_max)
        return self._get_obs()

    def _get_obs(self):
        # nu_m*3, D_m*3, p_m, D, f_bg_m*3, B, beta_max*3
        self.start_state = np.append(self.nu_m, self.D_m)
        self.start_state = np.append(self.start_state, self.p_m)
        self.start_state = np.append(self.start_state, self.D)
        self.start_state = np.append(self.start_state, self.f_bg_m)
        self.start_state = np.append(self.start_state, self.r1)
        self.start_state = np.append(self.start_state, self.r2)
        self.start_state = np.append(self.start_state, self.r3)
        self.start_state = np.append(self.start_state, self.beta_max)
        return self.state

    def step(self, action):  # 0: 选择服务的ue编号 ; 1: 方向theta; 2: 距离d; 3: offloading ratio
        step_redo = False
        is_terminal = False
        offloading_ratio_change = False
        reset_dist = False
        action = (action + 1) / 2  # 将取值区间位-1~1的action -> 0~1的action。避免原来action_bound为[0,1]时训练actor网络tanh函数一直取边界0

        # 如果action中的值为0，扣分
        for i in action:
            if i == 0:
                self.reward = self.reward - 1000
        #################寻找最优的服务对象UE######################
        # 对ddpg进行改进,输出层添加一层用来输出离散动作(实现结果不对)
        # 采用最近距离算法, 有错误.如果最近距离无人机就一直停在头上了(错)
        # 随机轮询:先生成一个随机数队列, 服务完就剔除UE, 队列为空再次随机生成(逻辑不对)
        # 控制变量映射到各个变量的取值区间

        self.gamma_m[0] = action[0]
        self.gamma_m[1] = action[1]
        self.gamma_m[2] = action[2]
        self.beta_m[0] = action[3]
        self.beta_m[1] = action[4]
        self.beta_m[2] = action[5]
        beta_sum = self.beta_m[0] + self.beta_m[1] + self.beta_m[2]
        # 带宽分配百分比应该小于100%
        if beta_sum > 1:
            self.reward -= 1000

        # 香农公式，更新RSU的带宽
        self.r1 = self.gamma_m[0] * self.B * math.log2(1 + (self.p * self.D * self.h2) / self.N)
        self.r2 = self.gamma_m[1] * self.B * math.log2(1 + (self.p * self.D * self.h2) / self.N)
        self.r3 = self.gamma_m[2] * self.B * math.log2(1 + (self.p * self.D * self.h2) / self.N)
        # 转换单位为MBps
        self.r1 = self.r1 / 1000 / 1000 / 8
        self.r2 = self.r2 / 1000 / 1000 / 8
        self.r3 = self.r3 / 1000 / 1000 / 8

        # 更新计算时间公式
        self.T_com_div = [self.phi / (self.beta_m[0] * self.f_core_m[0]) + self.c1 / (self.alpha_m * self.f_mem_m) + self.c2 / (self.beta_m[0] * self.f_core_m[0]) + self.T_m0,
                     self.phi / (self.beta_m[1] * self.f_core_m[1]) + self.c1 / (self.alpha_m * self.f_mem_m) + self.c2 / (self.beta_m[1] * self.f_core_m[1]) + self.T_m0,
                     self.phi / (self.beta_m[2] * self.f_core_m[2]) + self.c1 / (self.alpha_m * self.f_mem_m) + self.c2 / (self.beta_m[2] * self.f_core_m[2]) + self.T_m0]

        self.T_com_m = [math.ceil(self.nu_m[0] * self.D_m[0] / self.h_m) * self.T_com_div[0],
                   math.ceil(self.nu_m[1] * self.D_m[1] / self.h_m) * self.T_com_div[1],
                   math.ceil(self.nu_m[2] * self.D_m[2] / self.h_m) * self.T_com_div[2]]

        # 更新背景任务占用的算力资源
        self.f_bg_m = [(self.beta_max[0] - self.beta_m[0] * self.beta_max[0]) * self.f_core_m[0],
                  (self.beta_max[1] - self.beta_m[1] * self.beta_max[1]) * self.f_core_m[1],
                  (self.beta_max[2] - self.beta_m[2] * self.beta_max[2]) * self.f_core_m[2]]

        # 更新计算能耗
        self.E_com_m = self.C_m * (self.beta_max[0] * self.f_core_m[0]) ** 2 * self.T_com_m[0] - self.C_m * self.f_bg_m[0] * self.T_com_m[0] + self.C_m * (
            self.beta_max[1] * self.f_core_m[1]) ** 2 * self.T_com_m[1] - self.C_m * self.f_bg_m[1] * self.T_com_m[1] + self.C_m * (
                      self.beta_max[2] * self.f_core_m[2]) ** 2 * self.T_com_m[2] - self.C_m * self.f_bg_m[2] * self.T_com_m[2]

        # 更新上传时间
        self.T_up_m = [self.w / self.r1, self.w / self.r2, self.w / self.r3]
        # 更新上传能耗
        self.E_up_m = self.p_m * (self.T_up_m[0] + self.T_up_m[1] + self.T_up_m[2])

        # 更新reward
        self.reward = self.reward - self.E_com_m - self.E_up_m
        self.reset_step()
        # 记录更新参数
        file_name = 'output.txt'
        # file_name = 'output_ddpg_' + str(self.bandwidth_nums) + 'MHz.txt'
        # with open(file_name, 'a') as file_obj:
        #     file_obj.write("\nreward=" + '{:d}'.format(self.reward) + ", energy_upload: " + '{:d}'.format(
        #         int(self.E_up_m)) + ", enegy_computing:" + '{:.2f}'.format(self.E_com_m))
            #file_obj.write("\ndelay:" + '{:.2f}'.format(delay))
            #file_obj.write("\nUAV hover loc:" + "[" + '{:.2f}'.format(x) + ', ' + '{:.2f}'.format(y) + ']')  # 输出保留两位结果

        return self._get_obs(), self.reward

    # 重置ue任务大小，剩余总任务大小，ue位置，并记录到文件
    def reset2(self, delay, x, y, offloading_ratio, task_size, ue_id):
        self.sum_task_size -= self.task_list[ue_id]  # 剩余任务量
        for i in range(self.M):  # ue随机移动后的位置
            tmp = np.random.rand(2)
            theta_ue = tmp[0] * np.pi * 2  # ue 随机移动角度
            dis_ue = tmp[1] * self.delta_t * self.v_ue  # ue 随机移动距离
            self.loc_ue_list[i][0] = self.loc_ue_list[i][0] + math.cos(theta_ue) * dis_ue
            self.loc_ue_list[i][1] = self.loc_ue_list[i][1] + math.sin(theta_ue) * dis_ue
            self.loc_ue_list[i] = np.clip(self.loc_ue_list[i], 0, self.ground_width)
        self.reset_step()  # ue随机计算任务1~2Mbits # 4个ue，ue的遮挡情况
        # 记录UE花费
        file_name = 'output.txt'
        # file_name = 'output_ddpg_' + str(self.bandwidth_nums) + 'MHz.txt'
        with open(file_name, 'a') as file_obj:
            file_obj.write("\nUE-" + '{:d}'.format(ue_id) + ", task size: " + '{:d}'.format(
                int(task_size)) + ", offloading ratio:" + '{:.2f}'.format(offloading_ratio))
            file_obj.write("\ndelay:" + '{:.2f}'.format(delay))
            file_obj.write("\nUAV hover loc:" + "[" + '{:.2f}'.format(x) + ', ' + '{:.2f}'.format(y) + ']')  # 输出保留两位结果

    # 计算花费
    def com_delay(self, loc_ue, loc_uav, offloading_ratio, task_size, block_flag):
        dx = loc_uav[0] - loc_ue[0]
        dy = loc_uav[1] - loc_ue[1]
        dh = self.height
        dist_uav_ue = np.sqrt(dx * dx + dy * dy + dh * dh)
        p_noise = self.p_noisy_los
        if block_flag == 1:
            p_noise = self.p_noisy_nlos
        g_uav_ue = abs(self.alpha0 / dist_uav_ue ** 2)  # 信道增益
        trans_rate = self.B * math.log2(1 + self.p_uplink * g_uav_ue / p_noise)  # 上行链路传输速率bps
        t_tr = offloading_ratio * task_size / trans_rate  # 上传时延,1B=8bit
        t_edge_com = offloading_ratio * task_size / (self.f_uav / self.s)  # 在UAV边缘服务器上计算时延
        t_local_com = (1 - offloading_ratio) * task_size / (self.f_ue / self.s)  # 本地计算时延
        if t_tr < 0 or t_edge_com < 0 or t_local_com < 0:
            raise Exception(print("+++++++++++++++++!! error !!+++++++++++++++++++++++"))
        return max([t_tr + t_edge_com, t_local_com])  # 飞行时间影响因子
