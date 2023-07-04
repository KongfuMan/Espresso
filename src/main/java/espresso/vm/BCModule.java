package espresso.vm;


/**
 * Byte code module represent the byte code of a class
 *
 * */
public class BCModule {
    float minVer;
    float majVer;
    Constant[] constantPool;

    Method[] methods;

    public Method getMain(){
        for (Method m : methods){
            if (m.fullQualifiedName.equals("main")){
                return m;
            }
        }
        return null;
    }
}
