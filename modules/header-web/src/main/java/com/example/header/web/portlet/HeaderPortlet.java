package com.example.header.web.portlet;

import com.example.header.api.HeaderNavContributor;
import com.example.header.api.HeaderNavContributor.NavItem;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

@Component(
	immediate = true,
	property = {
		"javax.portlet.display-name=Header",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=com_example_header_web_HeaderPortlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class HeaderPortlet extends MVCPortlet {

	private final List<HeaderNavContributor> contributors = new ArrayList<>();

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		List<NavItem> items = new ArrayList<>();
		for (HeaderNavContributor contributor : contributors) {
			try {
				List<NavItem> contributed = contributor.getItems();
				if (contributed != null) {
					items.addAll(contributed);
				}
			} catch (Throwable t) {
				// Ignore bad contributors to keep header robust
			}
		}

		renderRequest.setAttribute("headerNavItems", items);

		super.doView(renderRequest, renderResponse);
	}

	@Reference(
		cardinality = ReferenceCardinality.MULTIPLE,
		policy = ReferencePolicy.DYNAMIC,
		unbind = "removeContributor"
	)
	protected void addContributor(HeaderNavContributor contributor) {
		contributors.add(contributor);
	}

	protected void removeContributor(HeaderNavContributor contributor) {
		contributors.remove(contributor);
	}
}