import { configureStore } from "@reduxjs/toolkit";
import MenuSlice from "../features/menuSlice";


let store = configureStore({
    reducer:{
        menus : MenuSlice
    }
})

export type RootState = ReturnType<typeof store.getState>
export default store;