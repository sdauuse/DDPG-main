# author: miaoyin
# time: 2024-03-18 23:14
import numpy as np
import pandas as pd
import time

np.random.seed(2)

# N_State = 6
# Actions = ['left', 'right']
# Epsilon = 0.9  # greedy police  90%选择最优动作，10%选择随机动作
# Alpha = 0.1  # 学习率
# Lambda = 0.9  # 折扣因子
# Max_Epsilon = 13  # 最多玩13回合
# Fresh_time = 0.3  # 走一步花0.3s

N_STATES = 6
ACTIONS = ['left', 'right']
MAX_EPISODES = 13
FRESH_TIME = 0.3
EPSILON = 0.9
ALPHA = 0.1
GAMMA = 0.9


def update_env(S, episode, step_counter):
    env_list = ['-'] * (N_STATES - 1) + ['T']
    if S == 'terminal':
        interaction = 'Episode %s: total_steps = %s' % (episode + 1, step_counter)
        print('\r{}'.format(interaction), end='')
        time.sleep(2)
        print('\r                                ', end='')
    else:
        env_list[S] = 'o'
        interaction = ''.join(env_list)
        print('\r{}'.format(interaction), end='')
        time.sleep(FRESH_TIME)


def get_env_feedback(S, A):
    if A == 'right':
        if S == N_STATES - 2:
            S_ = 'terminal'
            R = 1
        else:
            S_ = S + 1
            R = 0
    else:
        R = 0
        if S == 0:
            S_ = S
        else:
            S_ = S - 1
    return S_, R


def build_q_table(n_states, actions):
    table = pd.DataFrame(np.zeros((n_states, len(actions))), columns=actions)
    return table


def choose_action(state, q_table):
    state_actions = q_table.iloc[state, :]
    if (np.random.uniform() > EPSILON) or ((state_actions == 0).all()):
        action_name = np.random.choice(ACTIONS)
    else:
        action_name = state_actions.idxmax()
    return action_name


def rl():
    q_table = build_q_table(N_STATES, ACTIONS)
    for episode in range(MAX_EPISODES):
        #         print("episode: ", episode)
        #         print("q_table: ", q_table)
        step_counter = 0
        S = 0
        is_terminated = False
        update_env(S, episode, step_counter)
        while not is_terminated:
            A = choose_action(S, q_table)
            S_, R = get_env_feedback(S, A)
            q_predict = q_table.loc[S, A]
            if S_ != 'terminal':
                # q_table.iloc[S_, :].max() 表示选择S_开始的行，以及所有的列中的最大值
                q_target = R + GAMMA * q_table.iloc[S_, :].max()
            else:
                q_target = R
                is_terminated = True

            q_table.loc[S, A] += ALPHA * (q_target - q_predict)
            S = S_

            update_env(S, episode, step_counter + 1)
            step_counter += 1
    return q_table


if __name__ == "__main__":
    q_table = rl()
    print('\r\nQ-table:\n')
    print(q_table)
