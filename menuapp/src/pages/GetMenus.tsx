import { useEffect } from "react";
import Menus from "../components/Menus";
import axios from "axios";
import { useDispatch } from "react-redux";
import { selectAllMenu } from "../features/menuSlice";

const GetMenus = () => {
    const dispatch = useDispatch();

    useEffect(() =>{
        // Origin ? 프로토콜 + ip주소 + 포트번호
        // 브라우저 상에서는 같은 Origin끼리만 통신이 가능
        axios.get("http://localhost:8082/api/menus")
        .then((response)=> { //응답받는 데이터가 객체배열 형태
            dispatch(selectAllMenu(response.data));
            console.log(response.data); //얻어온 데이터 menus에 초기화 
        })
    },[])

    return (
        <>
            <div>
                <h4>전체 메뉴 조회(GET)</h4>
            </div>
            <Menus/>
        </>
    )

}
export default GetMenus;