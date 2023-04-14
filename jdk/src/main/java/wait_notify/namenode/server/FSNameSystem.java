package wait_notify.namenode.server;

/**
 * 负责管理元数据的核心组件
 *
 */
public class FSNameSystem {
    /**
     * 负责管理文件目录树的组件
     */
    FSDirectory directory;

    /**
     * 负责管理edits log写入磁盘的组件
     */
    FSEditLog editLog;

    public FSNameSystem() {
        this.directory = new FSDirectory();
        this.editLog = new FSEditLog();
    }

    /**
     * 创建目录
     * @param path 目录路径
     * @return 是否成功
     */
    public boolean mkdir(String path) {
        this.directory.mkdir(path);
        this.editLog.log("创建了一个目录" + path);
        return true;
    }
}
