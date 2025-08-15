package com.example.header.sample.contributor;

import com.example.header.api.HeaderNavContributor;

import java.util.Arrays;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(service = HeaderNavContributor.class)
public class BasicHeaderNavContributor implements HeaderNavContributor {
	@Override
	public List<NavItem> getItems() {
		return Arrays.asList(
			new NavItem("Tra cứu", "#tra-cuu", "search"),
			new NavItem("Phản ánh", "#phan-anh", "comment")
		);
	}
}