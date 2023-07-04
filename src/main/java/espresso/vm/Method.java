package espresso.vm;

import org.objectweb.asm.ByteVector;

import java.util.Map;

public class Method {
    public String fullQualifiedName;

    /** <instruction # : instruction >*/
    public Map<Long, String> instructions;

    /**
     * The local_variable_table array of the LocalVariableTable code attribute, or {@literal null}.
     */
    public String[] localVariableTable;
}
