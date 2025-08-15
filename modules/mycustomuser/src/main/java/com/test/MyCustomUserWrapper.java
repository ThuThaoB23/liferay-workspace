package com.test;

import com.liferay.portal.kernel.service.UserLocalServiceWrapper;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.service.component.annotations.Component;

/**
 * @author admin
 */
@Component(
        property = {
        },
        service = ServiceWrapper.class
)
public class MyCustomUserWrapper extends UserLocalServiceWrapper {

    public MyCustomUserWrapper() {
        super(null);
    }

    public int getUsersCount() {
        System.out.println("Custom logic before getting user count");
        return super.getUsersCount();
    }

}