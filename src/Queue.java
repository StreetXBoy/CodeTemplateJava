/**
 * @author 重新做人idea基础学习
 * @date 2022-3-31
 */
public interface Queue<E> {
    void offer(E e);

    E take();

    int size();
}