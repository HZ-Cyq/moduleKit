package wait_notify.namenode.server;

import java.util.List;

/**
 * 负责管理内存文件目录树的核心组件
 */
public class FSDirectory {

    private INodeDirectory dirTree;

    public FSDirectory() {
        dirTree = new INodeDirectory("/");
    }

    public void mkdir(String path) {
        // path = "/usr/wherehouse/hive"


    }

    private interface INode {

    }

    /**
     * 代表文件目录树中的一个目录
     */
    private class INodeDirectory implements INode {
        private String path;
        private List<INode> children;

        public INodeDirectory(String path) {
            this.path = path;
        }
    }

    private class INodeFile implements INode {

    }
}
