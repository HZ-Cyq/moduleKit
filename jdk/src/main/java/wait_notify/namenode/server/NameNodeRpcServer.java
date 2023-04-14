package wait_notify.namenode.server;

public class NameNodeRpcServer {

    private FSNameSystem nameSystem;

    public NameNodeRpcServer(FSNameSystem nameSystem) {
        this.nameSystem = nameSystem;
    }

    /**
     * 创建目录
     * @param path 目录路径
     * @return 是否创建成功
     */
    public boolean mkdir(String path) {
        return this.nameSystem.mkdir(path);
    }
}
