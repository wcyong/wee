<table>
	<tr>
		<td><strong>Sender</strong></td>
		<td><strong>Subject</strong></td>
		<td><strong>Date</strong></td>
	</tr>
	<tr ng-repeat="message in messages">
		<td>{{message.sender}}</td>
		<td><a href="#/view/{{message.id}}">{{message.subject}}</a></td>
		<td>{{message.date}}</td>
	</tr>
</table>