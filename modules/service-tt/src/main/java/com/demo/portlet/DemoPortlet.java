package com.demo.portlet;

import com.demo.constants.DemoPortletKeys;

import com.employee.model.Employee;
import com.employee.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.util.List;

/**
 * @author admin
 */
@Component(
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=Demo",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + DemoPortletKeys.DEMO,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class DemoPortlet extends MVCPortlet {
    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        List<Employee> employeeList = EmployeeLocalServiceUtil.getEmployees(0, EmployeeLocalServiceUtil.getEmployeesCount());
        renderRequest.setAttribute("employeeList", employeeList);

        super.doView(renderRequest, renderResponse);
    }
}