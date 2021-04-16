Hi There,

I have built a Backend clone of olx.in.
Implemented Offer Microservice as part of collaborative project.

Offer-MicroService
------------------
When user is interested in an item, and offer is made by the buyer to the seller. Seeing the offer by the offer counter offer can also be made by the seller.

These features have been implemented.

There 6 API's total.
-- To get all the offers of a user using user_Id
-- To get a particular offer using user_Id and item_Id
-- To maintain the original price of the item
-- To update the offerPrice by the buyer
-- To update the counterOffer by the Seller
-- To update the interested boolean by buyer or seller

ResponseEntity is implemented while returning anything by the API's
