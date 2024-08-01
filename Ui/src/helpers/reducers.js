import { combineReducers } from 'redux';

// Example reducer
const userReducer = (state = null, action) => {
  switch (action.type) {
    case 'SET_USER':
      return action.payload;
    case 'CLEAR_USER':
      return null;
    default:
      return state;
  }
};

const rootReducer = combineReducers({
  user: userReducer,
  // other reducers
});

export default rootReducer;
