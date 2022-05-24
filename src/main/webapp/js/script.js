//ユーザーの新規作成に関する処理
function addUser() {
	$('#operation_input').val('new');
	$('#user_form').submit();
}

//ユーザーの編集に関する処理
function editUser(id) {
	$('#operation_input').val('edit');
	$('#user_id_input').val(id);
	$('#user_form').submit();
}

//ユーザーの削除に関する処理
function deleteUser(id) {
	var ret = confirm('ユーザーを削除してもよろしいですか？');
	if(ret) {
		$('#operation_input').val('delete');
		$('#user_id_input').val(id);
		$('#user_form').submit();
	}
}

//クイズの新規作成に関する処理
function addQuiz() {
	$('#operation_quiz').val('new');
	$('#quiz_form').submit();
}

//クイズの削除に関する処理
function deleteQuiz(id) {
	var ret = confirm('ユーザーを削除してもよろしいですか？');
	if(ret) {
		$('#operation_quiz').val('delete');
		$('#quiz_id_input').val(id);
		$('#quiz_form').submit();
	}
}

//ユーザーの編集に関する処理
function editQuiz(id) {
	$('#operation_quiz').val('edit');
	$('#quiz_id_input').val(id);
	$('#quiz_form').submit();
}