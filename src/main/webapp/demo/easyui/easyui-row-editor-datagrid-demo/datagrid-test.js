/**
 * 获取当前datagrid中在编辑状态的行编号 用法： $('#tt').datagrid('getEditingRowIndexs');
 */
$.extend($.fn.datagrid.methods, {
	getEditingRowIndexs : function(jq) {
		var rows = $.data(jq[0], "datagrid").panel.find('.datagrid-row-editing');
		var indexs = [];
		rows.each(function(i, row) {
			var index = row.sectionRowIndex;
			if (indexs.indexOf(index) == -1) {
				indexs.push(index);
			}
		});
		return indexs;
	}
});

var EasyUIDataGrid = {
	// 设置列的值
	setFieldValue : function(fieldName, value, index, grid) {
		if (grid == undefined || grid == '') {
			grid = $('#editgrid');
		}
		if (index == undefined || index == '' || index == null) {
			index = 0;
		}
		var row = grid.datagrid('getRows')[index];
		if (row != null) {
			var editor = grid.datagrid('getEditor', {
				index : index,
				field : fieldName
			});
			// 如果这列有编辑器
			if (editor != null) {
				this.setValueToEditor(editor, value);
			} else {// 如果这列没有编辑器,直接操作dom显示值
				var view = $('.datagrid-view');
				// 需要判断一个页面中存在多个datagrid的情况
				for (var i = 0; i < view.length; i++) {
					if ($(view[i]).children(grid.selector).length > 0) {
						var view = $(view[i]).children('.datagrid-view2');
						var td = $(view).find('.datagrid-body td[field="' + fieldName + '"]')[index]
						var div = $(td).find('div')[0];
						$(div).text(value);
					}
				}

				row[fieldName] = value;
			}
			grid.datagrid('clearSelections');
		}
	},

	// 设置datagrid的编辑器的值
	setValueToEditor : function(editor, value) {
		switch (editor.type) {
		case "text":
			editor.target.val(value);
			break;
		case "combobox":
			editor.target.combobox("setValue", value);
			break;
		case "combotree":
			editor.target.combotree("setValue", value);
			break;
		case "textbox":
			editor.target.textbox("setValue", value);
			break;
		case "numberbox":
			editor.target.numberbox("setValue", value);
			break;
		case "datebox":
			editor.target.datebox("setValue", value);
			break;
		case "datetimebox":
			editor.target.datebox("setValue", value);
			break;
		default:
			editor.html = value;
			break;
		}
	},
	//阻止事件冒泡
	stopPropagation : function() {
		var evt = getEvent();
		if (evt.stopPropagation) {
			evt.stopPropagation();
		} else {
			evt.cancelBubble = true;
		}
	}
}

// 获取event
function getEvent() {
	if (document.all)
		return window.event;
	func = getEvent.caller;
	while (func != null) {
		var arg0 = func.arguments[0];
		if (arg0) {
			if ((arg0.constructor == Event || arg0.constructor == MouseEvent)
					|| (typeof (arg0) == "object" && arg0.preventDefault && arg0.stopPropagation)) {
				return arg0;
			}
		}
		func = func.caller;
	}
	return null;
}
