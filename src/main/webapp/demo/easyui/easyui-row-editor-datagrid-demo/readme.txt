功能简介	1.在可编辑表格中，下拉选择框选择一个项时，在同行其他列自动填充显示具体内容，而不需要在结束编辑时才能看见具体内容
	2.在鼠标点击空白位置时，自动结束编辑状态

1对应的实现方法：
		在选择下拉选框选项执行onSelect方法时，重置设置该列的值
		参见：EasyUIDataGrid.setFieldValue("name", name, editRowIndex, grid);

2对应的实现方法:
	首先在document上绑定click事件
	//为document绑定click事件
	$(document).on("click", function(e) {
		//结束datagrid editor编辑
		grid.datagrid('endEdit', editRowIndex);
		grid.datagrid('refreshRow', editRowIndex);
		//editIndex设置为undefined,否则再次点击同一表格时，editIndex==index，不会进入编辑状态
		editIndex = undefined;
	});
	在点击编辑列时，阻止事件冒泡到document,即不触发document上绑定的click事件
	function onClickRow(index, field) {
		//阻止事件冒泡,不触发document上的click事件,
		//即在编辑表格不会触发document上的结束编辑事件，点击空白区域会结束编辑
		EasyUIDataGrid.stopPropagation();
	}
