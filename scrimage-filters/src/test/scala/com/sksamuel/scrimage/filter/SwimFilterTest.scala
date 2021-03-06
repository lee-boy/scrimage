package com.sksamuel.scrimage.filter

import java.util.Random

import com.sksamuel.scrimage.ImmutableImage
import com.sksamuel.scrimage.nio.PngWriter
import org.scalatest.{FunSuite, Matchers}

class SwimFilterTest extends FunSuite with Matchers {

  implicit val writer: PngWriter = PngWriter.MaxCompression

  private val bird = ImmutableImage.fromResource("/bird_small.png")
  private val love = ImmutableImage.fromResource("/love.jpg")
  private val masks = ImmutableImage.fromResource("/masks.jpg")

  ignore("swim filter output matches expected") {
    bird.filter(new SwimFilter(new Random(0))) shouldBe ImmutableImage.fromResource("/com/sksamuel/scrimage/filters/swim/bird_small_swim.png")
    love.filter(new SwimFilter(new Random(0))) shouldBe ImmutableImage.fromResource("/com/sksamuel/scrimage/filters/swim/love_swim.png")
    masks.filter(new SwimFilter(new Random(0))) shouldBe ImmutableImage.fromResource("/com/sksamuel/scrimage/filters/swim/masks_swim.png")
  }

  ignore("swim filter should support amount") {
    masks.filter(new SwimFilter(new Random(0), 10, 2)) shouldBe ImmutableImage.fromResource("/com/sksamuel/scrimage/filters/swim/masks_swim_10_2.png")
    masks.filter(new SwimFilter(new Random(0), 16, 2)) shouldBe ImmutableImage.fromResource("/com/sksamuel/scrimage/filters/swim/masks_swim_16_2.png")
    masks.filter(new SwimFilter(new Random(0), 32, 2)) shouldBe ImmutableImage.fromResource("/com/sksamuel/scrimage/filters/swim/masks_swim_32_2.png")
  }
}
