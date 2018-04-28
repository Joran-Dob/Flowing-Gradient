package com.dynamitechetan.flowinggradient;

import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by DynamiteChetan on 17-07-2016.
 */
public class FlowingGradientClass {

  int Duration = 4000;
  RelativeLayout relativeLayout;
  LinearLayout linearLayout;
  ImageView imageView;
  ConstraintLayout constraintLayout;
  int alphaint;
  int resourceId;
  AnimationDrawable frameAnimation;

  public FlowingGradientClass setTransitionDuration(int time) {
    this.Duration = time;

    return this;
  }

  public FlowingGradientClass onLinearLayout(LinearLayout ll) {
    this.linearLayout = ll;
    return this;
  }

  public FlowingGradientClass onImageView(ImageView im) {
    this.imageView = im;
    return this;
  }

  public FlowingGradientClass onRelativeLayout(RelativeLayout rl) {
    this.relativeLayout = rl;
    return this;
  }

  public FlowingGradientClass onConstraintsLayout(ConstraintLayout constraintLayout) {
    this.constraintLayout = constraintLayout;
    return this;
  }

  public FlowingGradientClass start() {

    if (linearLayout != null) {
      linearLayout.setBackgroundResource(resourceId);
    } else if (relativeLayout != null) {
      relativeLayout.setBackgroundResource(resourceId);
    } else if (imageView != null) {
      imageView.setBackgroundResource(resourceId);
    } else if (constraintLayout != null) {
      constraintLayout.setBackgroundResource(resourceId);
    }
    if (linearLayout != null) {
      frameAnimation = (AnimationDrawable) linearLayout.getBackground();
    } else if (relativeLayout != null) {
      frameAnimation = (AnimationDrawable) relativeLayout.getBackground();
    } else if (imageView != null) {
      frameAnimation = (AnimationDrawable) imageView.getBackground();
    } else if (constraintLayout != null) {
      frameAnimation = (AnimationDrawable) constraintLayout.getBackground();
    }
    frameAnimation.setEnterFadeDuration(Duration);
    frameAnimation.setExitFadeDuration(Duration);
    frameAnimation.start();

    return this;
  }

  public FlowingGradientClass stop() {
    frameAnimation.stop();
    return this;
  }

  public FlowingGradientClass setBackgroundResource(int resourceId) {
    this.resourceId = resourceId;
    return this;
  }

  public FlowingGradientClass setAlpha(int alphaint) {
    this.alphaint = alphaint;
    frameAnimation.setAlpha(alphaint);
    return this;
  }
}