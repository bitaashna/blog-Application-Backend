# blog-Application-Backend
This is a RESTful web service for a blogging platform.The API is built using Java and the Spring Framework.

## Technical Stacks
  * Spring Boot
  * Spring Framework
  * Spring Data JPA
  * MySQL
  * Hibernate
  * Java
  * Postman

## Modules
  * Users Module
  * Category Module
  * Post Module
  * Comment Module

## Features
  * Users Features:
      * User creation: add user
      * User updation: update information of user
      * User retrieval: Retrieves user information based on the user ID.
      * User deletion: Deletes a user account from the system.
      * User listing: Retrieves a list of all users (typically for administrative purposes).

  * Category Features:
      * Category creation: Enables the creation of new categories.
      * Category updating: Allows users to update existing categories.
      * Category retrieval: Retrieves a specific category based on the category ID.
      * Category deletion: Deletes a category from the system.
      * Category listing: Retrieves a list of all categories.

  * Post Features:
      * Post creation: Allows users to create new posts.
      * Post updating: Enables users to update their existing posts.
      * Post retrieval: Retrieves a specific post based on the post ID.
      * Post deletion: Deletes a post from the system.
      * Post listing: Retrieves a list of posts based on various criteria, such as user, category, or keyword.

  * Comment Features:
      * Comment creation: Allows users to add comments to specific posts.
      * Comment deletion: Deletes a comment from a post.
   
## ER Diagram
![schema](https://github.com/bitaashna/blog-Application-Backend/assets/57864526/38c3698a-e30b-4283-abb8-3d468350b7b3)

### Users Module

* `POST /register:` Purpose:` Registers a new user.
`Request Body:` JSON object representing the user details to be registered (UserDto).
`Response:` Returns a UserDto object representing the registered user and HTTP status code 201 (Created).

* `PUT /update/{userId}:`
`Purpose:` Updates an existing user.
`Path Parameter:` userId - The ID of the user to update.
`Request Body:` JSON object representing the updated user details (UserDto).
`Response:` Returns a UserDto object representing the updated user and HTTP status code 202 (Accepted).

* `GET /{userId}:`
`Purpose:` Retrieves a user by their ID.
`Path Parameter:` userId - The ID of the user to retrieve.
`Response:` Returns a UserDto object representing the retrieved user and HTTP status code 200 (OK).

* `DELETE /{userId}:`
`Purpose:` Deletes a user by their ID.
`Path Parameter:` userId - The ID of the user to delete.
`Response:` Returns an HTTP status code 200 (OK) if the user is successfully deleted.

* `GET /getAll:`
`Purpose:` Retrieves all users by Admin.
`Response:` Returns a list of UserDto objects representing all users and HTTP status code 200 (OK).


### Post Module

* `POST /user/{userId}/category/{categoryId}/posts:`
`Purpose:` Creates a new post for a specific user and category.
`Path Parameters:`
`userId:` The ID of the user creating the post.
`categoryId:` The ID of the category for the post.
`Request Body:` JSON object representing the post details (PostDto).
`Response:` Returns a PostDto object representing the created post and HTTP status code 201 (Created).

* `PUT /post/{postId}:`
`Purpose:` Updates an existing post.
`Path Parameter:` postId - The ID of the post to update.
`Request Body:` JSON object representing the updated post details (PostDto).
`Response:` Returns a PostDto object representing the updated post and HTTP status code 200 (OK).

* `GET /post/{postId}:`
`Purpose:` Retrieves a post by its ID.
`Path Parameter:` postId - The ID of the post to retrieve.
`Response:` Returns a PostDto object representing the retrieved post and HTTP status code 202 (Accepted).

* `DELETE /{postId}/post:`
`Purpose:` Deletes a post by its ID.
`Path Parameter:` postId - The ID of the post to delete.
`Response:` Returns an HTTP status code 200 (OK) if the post is successfully deleted.

* `GET /allposts:`
`Purpose:` Retrieves all posts by user and admin.
`Response:` Returns a list of PostDto objects representing all posts and HTTP status code 202 (Accepted).

* `GET /allpost/:`
`Purpose:` Retrieves all posts with pagination and sorting options.
`Request Parameters:`
`pageNumber (optional):` The page number to retrieve (default: 1).
`pageSize (optional):` The number of posts per page (default: 10).
`sortBy (optional):` The field to sort the posts by (default: predefined value).
`sortDir (optional):` The sort direction (asc/desc) for the posts (default: predefined value).
`Response:` Returns a PostResponse object containing paginated post results and HTTP status code 200 (OK).

* `GET /category/{categoryId}/posts:`

`Purpose:` Retrieves posts for a specific category with pagination.
`Path Parameter:` categoryId - The ID of the category to retrieve posts for.
`Request Parameters:`
`pageNumber (optional):` The page number to retrieve (default: 1).
`pageSize (optional):` The number of posts per page (default: 10).
`Response:` Returns a PostResponse object containing paginated post results and HTTP status code 202 (Accepted).

* `GET /user/{userId}/posts:`
`Purpose:` Retrieves posts for a specific user with pagination.
`Path Parameter:` userId - The ID of the user to retrieve posts for.
`Request Parameters:`
`pageNumber (optional):` The page number to retrieve (default: 1).
`pageSize (optional):` The number of posts per page (default: 10).
`Response:` Returns a PostResponse object containing paginated post results and HTTP status code 202 (Accepted).

* `GET /posts/{keyword}:`
`Purpose:` Retrieves posts by searching for a keyword in the title.
`Path Parameter: keyword -` The keyword to search


 ### Comment Module
 
 * `POST/{postId}/user/{userId}/comment:`
 `Purpose:` Creates a new comment for a specific post and user.
`Path Parameters:`
`postId:` The ID of the post the comment belongs to.
`userId:` The ID of the user creating the comment.
`Request Body:` JSON object representing the comment details (CommentDto).
`Response:` Returns a CommentDto object representing the created comment and HTTP status code 201 (Created).

* `DELETE /comment/{commentId}:`
`Purpose:` Deletes a comment by its ID.
`Path Parameter:` commentId - The ID of the comment to delete.
`Response:` Returns an HTTP status code 200 (OK) if the comment is successfully deleted.


 ### Category Module
 
 * `POST /add:`
`Purpose:` Creates a new category.
`Request Body:` JSON object representing the category details (CategoryDto).
`Response:` Returns a CategoryDto object representing the created category and HTTP status code 201 (Created).

* `PUT /update/{categoryId}:`
`Purpose:` Updates an existing category.
`Path Parameter:` categoryId - The ID of the category to update.
`Request Body:` JSON object representing the updated category details (CategoryDto).
`Response:` Returns a CategoryDto object representing the updated category and HTTP status code 202 (Accepted).

* `GET /{categoryId}:`
`Purpose:` Retrieves a category by its ID.
`Path Parameter:` categoryId - The ID of the category to retrieve.
`Response:` Returns a CategoryDto object representing the retrieved category and HTTP status code 200 (OK).

* `DELETE /{categoryId}:`
`Purpose:` Deletes a category by its ID.
`Path Parameter:` categoryId - The ID of the category to delete.
`Response:` Returns an HTTP status code 200 (OK) if the category is successfully deleted.

* `GET /getAll:`
`Purpose:` Retrieves all categories.
`Response:` Returns a list of CategoryDto objects representing all categories and HTTP status code 200 (OK).
 
