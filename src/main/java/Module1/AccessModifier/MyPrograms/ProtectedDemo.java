package Module1.AccessModifier.MyPrograms;

import Module1.AccessModifier.ProtectedParent;

public class ProtectedDemo extends ProtectedParent {
    void test () {
        System.out.println("test: "+x);
    }

    public static void main(String[] args) {
        ProtectedParent protectedParent = new ProtectedParent();
        //The key is to understand that protected members can only be accessed through inheritance
        // when in a different package, not through an instance of the parent class.
        // System.out.println("test: "+protectedParent.x);//
    }


}
