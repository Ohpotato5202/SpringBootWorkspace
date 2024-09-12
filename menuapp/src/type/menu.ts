export type MenuType = 'all'|'kr'|'jp'|'ch'
export type MenuTaste = 'all'|'mild' | 'hot'

export interface Menu {
    id : number,
    restaurant : string,
    name : string,
    price : number,
    type : MenuType,
    taste : MenuTaste
}

export const initialMenu:Menu = {
    id : 0,
    restaurant: '',
    name: '',
    price : 0,
    type : 'kr',
    taste : 'mild'
} as const;


export const initialMenuList:Menu[] = [];

export type SearchKeyword ={
    type : MenuType;
    taste : MenuTaste;
}