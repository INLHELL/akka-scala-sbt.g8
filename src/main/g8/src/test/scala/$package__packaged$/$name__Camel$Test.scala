package com.genesyslab

import org.scalatest._
import com.typesafe.scalalogging._

class RxAggregatorTest extends FunSuite with BeforeAndAfterEach with BeforeAndAfterAll with LazyLogging {

  override def beforeAll() {
    logger.info("Before all tests...")
  }

  override def afterAll() {
    logger.info("After all tests...")
  }

  override def beforeEach() {
    logger.info("Before test...")
  }

  override def afterEach() {
    logger.info("After test...")
  }

  test("first test") {
    logger.info("First test...")
    assert(0 === 0)
  }

  test("second test") {
    logger.info("Second test...")
    assert(1 === 1)
  }
}
