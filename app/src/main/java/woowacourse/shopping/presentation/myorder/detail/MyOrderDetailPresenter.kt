package woowacourse.shopping.presentation.myorder.detail

import woowacourse.shopping.presentation.mapper.toDomain
import woowacourse.shopping.presentation.mapper.toPresentation
import woowacourse.shopping.presentation.model.OrderProductModel
import woowacourse.shopping.repository.OrderRepository

class MyOrderDetailPresenter(
    private val view: MyOrderDetailContract.View,
    private val orderRepository: OrderRepository,
    private val orderId: Int,
) : MyOrderDetailContract.Presenter {

    override fun loadOrderDetail() {
        orderRepository.getOrderDetail(orderId) { orderDetail ->
            if (orderDetail == null) return@getOrderDetail
            val orderDetailModel = orderDetail.toPresentation()
            view.setOrderProducts(orderDetailModel.orderItems.list)
            view.setPaymentInfo(orderDetailModel)
        }
    }

    override fun updateProductPrice(orderProductModel: OrderProductModel) {
        val price = orderProductModel.toDomain().totalPrice
        view.setProductPrice(price)
    }
}