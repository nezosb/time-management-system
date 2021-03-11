package models

import business.memory.UserInMemoryDAO
import com.google.inject.ImplementedBy

import scala.concurrent.{ExecutionContext, Future}

case class User(username: String, password: String, userID: Long = 0L)

@ImplementedBy(classOf[UserInMemoryDAO])
trait UserDAO {
  def getUser(username: String)(implicit ex: ExecutionContext) : Future[Option[User]]
  def addUser(username: String, password: String): Future[Option[User]]
  def deleteUser(username: String): Future[Int]
}

