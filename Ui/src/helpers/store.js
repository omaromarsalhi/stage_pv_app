import { createStore } from 'redux';
import { persistStore, persistReducer } from 'redux-persist';
import storage from 'redux-persist/lib/storage'; // You can also use other storage mechanisms
import rootReducer from './reducers'; // Import your root reducer

// Configuration for redux-persist
const persistConfig = {
  key: 'root',
  storage,
};

const persistedReducer = persistReducer(persistConfig, rootReducer);

// Create the store with the persisted reducer
export const store = createStore(persistedReducer);
export const persistor = persistStore(store);
