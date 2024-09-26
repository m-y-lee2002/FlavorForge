import React,{useContext} from 'react';
import "../styles/modal.css";
import { alldishescontext } from './alldishescontext';
import { dishpositioncontext } from './dishpositioncontext';
const Modal = ({setOpenModal }) => {
  const { allDishes } = useContext(alldishescontext);
  const {dishPosition} = useContext(dishpositioncontext);
    return (
        <div className="modalBackground">
        <div className="modalContainer">
          <div className="titleCloseBtn">
            <button
              onClick={() => {
                setOpenModal(false);
              }}
            >
              X
            </button>
          </div>
          <div className="title">
            <h1>Additional Information</h1>
          </div>
          <div className="body">
            <p>Calories {allDishes[dishPosition].calories}</p>
            <p>Carbs {allDishes[dishPosition].carbs}g </p>
            <p>Dietary Fiber {allDishes[dishPosition].fibers}g</p>
            <p>Protein {allDishes[dishPosition].protein}g</p>
          </div>
          <div className="footer">
            {/* <button
              onClick={() => {
                setOpenModal(false);
              }}
              id="cancelBtn"
            >
              Cancel
            </button> */}
          </div>
        </div>
      </div>
    );
}

export default Modal;
