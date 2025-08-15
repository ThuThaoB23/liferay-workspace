package com.example.header.api;

import java.util.List;

/**
 * Provides dynamic navbar items for the header portlet.
 */
public interface HeaderNavContributor {
	/**
	 * Returns a list of items to render in the navbar. Each item is a simple DTO.
	 */
	List<NavItem> getItems();

	class NavItem {
		public final String label;
		public final String href;
		public final String icon;

		public NavItem(String label, String href, String icon) {
			this.label = label;
			this.href = href;
			this.icon = icon;
		}
	}
}