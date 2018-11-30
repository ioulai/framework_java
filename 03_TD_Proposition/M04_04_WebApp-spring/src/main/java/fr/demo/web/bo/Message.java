package fr.demo.web.bo;

import org.springframework.stereotype.Component;

/**
 * Simple BO.
 * 
 * @author Gaël Sigogneau
 * @since 22 nov. 2018
 *
 */
@Component
public class Message {

    private String msg;

    public Message() {
        this.msg = "hellow world";
    }

    public Message(String msg) {
        super();
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Message [msg=");
        builder.append(msg);
        builder.append("]");
        return builder.toString();
    }

}
