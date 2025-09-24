package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBo;
import lk.ijse.bo.SuperBo;
import lk.ijse.dto.PaymentDTO;
import java.util.List;

public interface PaymentBO extends SuperBo {
    boolean savePayment(PaymentDTO dto) throws Exception;
    boolean updatePayment(PaymentDTO dto) throws Exception;
    boolean deletePayment(int id) throws Exception;
    List<PaymentDTO> getAllPayments() throws Exception;
    PaymentDTO getPayment(int id) throws Exception;
}