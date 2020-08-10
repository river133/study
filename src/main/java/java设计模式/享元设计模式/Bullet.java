package java设计模式.享元设计模式;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/*
共享元素
 */
public class Bullet {
    public UUID id = UUID.randomUUID();
    boolean living = true;

    @Override
    public String toString() {
        return "Bullet{" +
                "id=" + id +
                ", living=" + living +
                '}';
    }
    public class BulletPool{
        List<Bullet> bullets =new ArrayList<>();
        {
            for (int i = 0; i < 5; i++) {
                bullets.add(new Bullet());
            }
        }
        //从池子共享数据
        public Bullet getBullet(){
            for (int i = 0; i < bullets.size(); i++) {
                Bullet b = bullets.get(i);
                if(!b.living)return b;
            }
                return new Bullet();
        }
    }
}

