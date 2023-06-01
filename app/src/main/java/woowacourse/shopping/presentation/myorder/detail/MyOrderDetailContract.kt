package woowacourse.shopping.presentation.myorder.detail

import woowacourse.shopping.presentation.model.OrderDetailModel
import woowacourse.shopping.presentation.model.OrderProductModel

interface MyOrderDetailContract {
    interface Presenter {
        fun loadOrderDetail()
    }

    interface View {
        fun setOrderProducts(orderProducts: List<OrderProductModel>)
        fun setPaymentInfo(orderDetailModel: OrderDetailModel)
    }
}
