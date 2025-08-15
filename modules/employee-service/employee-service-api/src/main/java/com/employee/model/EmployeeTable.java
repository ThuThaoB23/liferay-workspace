/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.employee.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;employee&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Employee
 * @generated
 */
public class EmployeeTable extends BaseTable<EmployeeTable> {

	public static final EmployeeTable INSTANCE = new EmployeeTable();

	public final Column<EmployeeTable, Integer> empId = createColumn(
		"empId", Integer.class, Types.INTEGER, Column.FLAG_PRIMARY);
	public final Column<EmployeeTable, String> firstName = createColumn(
		"firstName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private EmployeeTable() {
		super("employee", EmployeeTable::new);
	}

}