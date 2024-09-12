import { createSlice, PayloadAction } from "@reduxjs/toolkit"
import { initialMenuList,Menu } from "../type/menu"

let menuSlice =createSlice({
    name : 'menu',
    initialState : initialMenuList ,
    reducers : {
        selectAllMenu : (state, action:PayloadAction<Menu[]>) => {
            return action.payload;
        }
    }
});

export const {selectAllMenu} =menuSlice.actions;
export default menuSlice.reducer;