package me.ohvalsgod.overwatch.util.cooldown;

import lombok.Data;
import me.ohvalsgod.overwatch.util.TimeUtil;

@Data
public class Cooldown {

    private long start = System.currentTimeMillis();
    private long expire;

    public Cooldown(long duration) {
        this.expire = this.start + duration;
    }

    public long getPassed() {
        return System.currentTimeMillis() - this.start;
    }

    public long getRemaining() {
        return this.expire - System.currentTimeMillis();
    }

    public boolean hasExpired() {
        return System.currentTimeMillis() - this.expire >= 0;
    }

    public String getTimeLeft() {
        return TimeUtil.formatSeconds(this.getRemaining());
    }

}
