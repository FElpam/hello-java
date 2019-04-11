package jvm.exception;

import java.util.ArrayList;

/**
 * OOM测试：不断向java堆添加新的对象
 * 解决方法：1.先检查是否有内存泄漏，这一步可以通过查看GC Roots引用链得到
 * 2.如果无内存泄漏，就看是否能扩大堆内存，是否有对象存活太长
 */
public class HeapOOM {
    static class OOMObject{}

    public static void main(String[] args) {
        ArrayList<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
