package cn.thinkinjava.filter;

import cn.thinkinjava.core.Invoker;
import cn.thinkinjava.core.ServiceConfig;
import cn.thinkinjava.rpc.Request;
import cn.thinkinjava.rpc.Response;

/**
 * @author 莫那·鲁道
 * @date 2018/10/16-下午5:01
 */
public class FilterWrapper implements Invoker {

    private Filter next;

    private Invoker invoker;

    private ServiceConfig config;

    public FilterWrapper(Filter next, Invoker invoker) {
        this.next = next;
        this.invoker = invoker;
        this.config = invoker.getConfig();
    }


    public Response invoke(Request args) {
        if (next != null) {
            return next.filter(invoker, args);
        } else {
            return invoker.invoke(args);
        }
    }

    public ServiceConfig getConfig() {
        return config;
    }
}
