import * as types from '../constants/actionTypes/dashboardActionTypes';

const initialState = {
    transactions: []
}

export const dashboardReducer = (state = initialState, action) => {
    switch (action.type) {
        case types.GET_ALL_TRANSACTIONS:
            return {
                ...state,
                transactions: action.payload
            }
        default:
            return state;
    }
}
