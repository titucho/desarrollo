import com.example.todolist.data.productsExample


data class Product (
    val name: String,
            var checked: Boolean = false

) {

}
fun getFakeShoppingProducts() = productsExample.map { Product(it) }
