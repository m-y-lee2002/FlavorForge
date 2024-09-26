import React,{useState} from 'react';
import Modal from './modal';
const Additionalinfobutton = () => {
    const [openModal, setModalOpen] = useState(false);
    return (
        <div>
            <button className="openModalBtn"onClick={() => {setModalOpen(true);}}>Additional Information</button>

{openModal && <Modal setOpenModal={setModalOpen} />}
        </div>
    );
}

export default Additionalinfobutton;
