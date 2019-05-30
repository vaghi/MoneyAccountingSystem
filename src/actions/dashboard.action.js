import * as types from '../constants/actionTypes/dashboardActionTypes.js';
import Fetcher from '../helpers/fetcher';

const fetcher = new Fetcher();

export const getTransactions = (itemId) => (dispatch) => {

    const successCallback = (res) => {
        dispatch({ type: types.GET_ALL_TRANSACTIONS, payload: res });
    }

    const url = `http://localhost:4567`;
    fetcher.get(url, successCallback);
};
