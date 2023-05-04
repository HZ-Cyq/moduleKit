package org.example;

public final class EventKey {
    public static final int GAME_INIT = 0x1001; //
    public static final int GAME_INIT_DONE = 0x1002; // 游戏启动
    public static final int GAME_STARTUP_FINISH = 0x1003; // 游戏启动完毕

    // public static final int PLAYER_LOADDATA_FINISH = 0x1003;// 加载用户数据完毕
    public static final int PLAYER_LOGOUT = 0x1004; // 下线
    public static final int SERVICE_LOAD_FINISH = 0x1005;// Service数据读取完毕

    /** 玩家进行零时所需清理 */
    public static final int PLAYER_RESET_ZERO = 0x5001;    //玩家进行零时所需清理
    // 20485
    public static final int PLAYER_RESET_FIVE = 0x5005;    //玩家进行5时所需清理

    // 24576
    public static final int PLAYER_MINUTE_JOB = 0x6001;
    // 24578
    public static final int PLAYER_LV_UP_EVENT = 0x6002;                    // 玩家升级事件
    // 24579
    public static final int PLAYER_VIP_LV_UP_EVENT = 0x6003;                // 玩家VIP升级事件
    // 24580
    public static final int PLAYER_DAILY_EVENT = 0x6004;                    // 玩家日常行为事件

    public static void main(String[] args) {
        System.out.println("hell");
    }

}