package bsh;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * 运行的时候将temp下的myscript.bsh添加到bsh项目里来(和Player同级)
 */
public class CallScript2 {
    public static void main( String [] args ) throws Exception {
        try {
//            Interpreter.DEBUG = true;
//            Interpreter.TRACE = true;
            Interpreter interpreter = new Interpreter();
            PlayerManager.getInstance().add(2,"name2");
            PlayerManager.getInstance().add(3,"name3");
            while (true) {
                TimeUnit.SECONDS.sleep(5);
                String path = "bsh/src/main/java/bsh/myscript.bsh";
                File file = new File(path);
                if(!file.exists()) {
                    System.out.println("myscript.bsh文件不存在");
                    continue;
                }

                Object obj = interpreter.source(path);
                System.out.println(obj);
                System.out.println(PlayerManager.getInstance().getPlayerMap());

                File file2 = new File(path);
                if(file.exists()) {
                    boolean delete = file2.delete();
                    if(delete) {
                        System.out.println("myscript.bsh文件删除成功");
                    } else {
                        System.out.println("myscript.bsh文件删除失败");
                    }
                }
            }
        } catch ( TargetError e ) {
            System.out.println(
                    "The script or code called by the script threw an exception: "
                            + e.getTarget() );
        } catch ( EvalError e2 )    {
            System.out.println(
                    "There was an error in evaluating the script:" + e2 );
        }
    }
}