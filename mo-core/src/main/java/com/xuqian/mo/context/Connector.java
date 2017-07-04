package com.xuqian.mo.context;

/**
 * Created by xuqian on 04/07/17.
 */
public interface Connector {

    boolean isConnected();

    Session session();

    void setSession(Session session);

    void disconnect();
}
