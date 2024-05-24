I have developed a food delivery app utilizing Jetpack Compose and Kotlin, which offers a seamless and modern user interface. The app begins with a login page, ensuring that only authenticated users can access its features. Upon successful login, users are presented with a list of available food products, displayed in a visually appealing manner using a LazyColumn. This efficient component of Jetpack Compose enables the smooth rendering of large datasets.

The product list is dynamically populated through API calls handled by Retrofit, ensuring that users receive the most current and accurate information. Each product in the list features an image and a name, making it easy for users to identify their desired items.

When a user clicks on a food item, it is added to their cart. This interaction is designed to be intuitive and quick, enhancing the user experience. After adding items to the cart, users can proceed to the final billing page. Here, they can review their selected items, ensuring accuracy before completing their order.

To facilitate delivery, I integrated a feature that captures the current user location using the LocationViewModel. This model efficiently fetches the user's location, ensuring that the delivery address is accurate and up-to-date. This feature not only improves the delivery process but also enhances user convenience by automating the address entry.

The final step in the app is the checkout process, where users can select their preferred mode of payment. The app supports various payment methods, catering to different user preferences and ensuring a smooth transaction experience.

By combining Jetpack Compose's modern UI capabilities with Kotlin's robust features, and integrating essential libraries like Retrofit for API handling and LocationViewModel for location services, the app provides a comprehensive and user-friendly food delivery solution. Each component, from login to checkout, is designed to ensure efficiency, accuracy, and ease of use, creating a seamless experience for the user. This project not only showcases advanced Android development techniques but also addresses practical user needs in the food delivery space.
