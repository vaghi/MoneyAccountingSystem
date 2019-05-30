import connect from 'react-redux/es/connect/connect';
import { getTransactions } from "../../actions/dashboard.action";
import Dashboard from './dashboard';

const actions = {
    getTransactions
}

function mapStateToProps(state) {
    const { transactions } = state.dashboardReducer;

    return {
        transactions
    }
}

export default connect(mapStateToProps, actions) (Dashboard);
