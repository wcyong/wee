���ܼ��	1.�ڿɱ༭����У�����ѡ���ѡ��һ����ʱ����ͬ���������Զ������ʾ�������ݣ�������Ҫ�ڽ����༭ʱ���ܿ�����������
	2.��������հ�λ��ʱ���Զ������༭״̬

1��Ӧ��ʵ�ַ�����
		��ѡ������ѡ��ѡ��ִ��onSelect����ʱ���������ø��е�ֵ
		�μ���EasyUIDataGrid.setFieldValue("name", name, editRowIndex, grid);

2��Ӧ��ʵ�ַ���:
	������document�ϰ�click�¼�
	//Ϊdocument��click�¼�
	$(document).on("click", function(e) {
		//����datagrid editor�༭
		grid.datagrid('endEdit', editRowIndex);
		grid.datagrid('refreshRow', editRowIndex);
		//editIndex����Ϊundefined,�����ٴε��ͬһ���ʱ��editIndex==index���������༭״̬
		editIndex = undefined;
	});
	�ڵ���༭��ʱ����ֹ�¼�ð�ݵ�document,��������document�ϰ󶨵�click�¼�
	function onClickRow(index, field) {
		//��ֹ�¼�ð��,������document�ϵ�click�¼�,
		//���ڱ༭��񲻻ᴥ��document�ϵĽ����༭�¼�������հ����������༭
		EasyUIDataGrid.stopPropagation();
	}
