package wait_notify.namenode.server;

/**
 * 核心启动类
 */
public class NameNode {

    private volatile Boolean shouldRun;

    private FSNameSystem nameSystem;

    private NameNodeRpcServer rpcServer;

    private void initialize() {
        this.nameSystem = new FSNameSystem();
        this.rpcServer = new NameNodeRpcServer(nameSystem);
    }

    public NameNode() {
        this.shouldRun = true;
    }

    private void run() {
        while (shouldRun) {
            try {
                Thread.sleep(10 * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        NameNode nameNode = new NameNode();
        nameNode.initialize();
        nameNode.run();
    }

    /**
     * 创建目录
     * @param path 目录路径
     * @return 是否创建成功
     */
    public boolean mkdir(String path) {
        return true;
    }

    /**
     * 启动这个rpc server
     */
    public void start() {
        System.out.println("开始监听指定的rpc server的端口， 来接收请求");
    }
}
