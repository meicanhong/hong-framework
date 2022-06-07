package hongframework.context;

import java.util.EventObject;

/**
 * @Author: canhong
 * @Date: 2022/6/7 11:58
 */
public abstract class ApplicationEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
