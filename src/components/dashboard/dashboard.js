import React, { PureComponent } from 'react';
import Collapsible from 'react-collapsible';
import './dashboard.css';

class Dashboard extends PureComponent {

	componentDidMount() {
		this.props.getTransactions();
		setInterval(this.props.getTransactions, 5000);
	}

	render() {
		const { transactions } = this.props;

		return (
			<div>
				{
					transactions.map(t => {
						return <div key={t.id}>
							<Collapsible triggerClassName={t.type === 'debit' ? 'debit-style-trigger' : ""} trigger={`Type: ${t.type} - Amount: ${t.amount}`}>
								<p>{`Id: ${t.id}`}</p>
								<p>{`Effective Date: ${new Date(t.effectiveDate.seconds * 1000)}`}</p>
							</Collapsible>
						</div>
					})
				}
			</div>
		);
	}
}

export default Dashboard;
